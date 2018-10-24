import {Planning} from "../../models/planning";
import {Constants} from "../../../assets/constants";
import {Injectable} from "@angular/core";
import * as moment from 'moment';

@Injectable({
  providedIn: 'root'
})
export class CalendarView {
// @ calendar object
  calendarObject(_this) {

    let _ths = this;

    return {
      editable: true,
      schedulerLicenseKey: Constants.SCHEDULER_LICENSE_KEY,
      header: _ths.getHeader(),
      defaultView: _this.defaultView,
      height: 640,
      selectable: true,
      selectHelper: true,
      locale: 'fr',
      // timeFormat: 'H:mm',
      // slotLabelFormat: 'H:mm',
      allDaySlot: false,
      // eventSources: [],
      viewRender(view) {
        _this.calendarTitle = view.title.replace(/undefined/g, '');
      },
      select(start, end) {
        let testEvent = new Planning();
        testEvent.start = start;
        testEvent.end = end;
        _this.addEvent(start, end);
      },
      eventClick(calEvent, jsEvent, view) {
        console.log(calEvent);
        _this.eventClick(calEvent);
      },
      eventResize(event, delta, revertFunc) {
        _this.eventResize(event);
      },
      eventDrop(event, delta, revertFunc) {
        _this.eventDrop(event);
      },
      eventRender: function (event) {
        if (event.ranges) {
          return (event.ranges.filter(function (range) { // test event against all the ranges

            return (event.start.isBefore(range.end) &&
              event.end.isAfter(range.start));

          }).length) > 0;
        }
      },
      selectOverlap(event) {
        if ((event.ranges.filter(function (range) {
          if (range.end === undefined) {
            range.end = '2100/12/31';
          }
          return (event.start.isBefore(moment.utc(range.end, 'YYYY-MM-DD')) &&
            event.end.isAfter(moment.utc(range.start, 'YYYY-MM-DD')));

        }).length) > 0) {
          return false;
        }
        else {
          return true;
        }
      },
      /*
      eventOverlap(stillEvent, movingEvent) {
        return stillEvent.allDay && movingEvent.allDay;
      },
      */
    };
  }

  // @ header for calendar
  getHeader() {

    let data = {

      left: '',
      center: '',
      right: ''
    };
    return data;
  }
}
