package com.krhonos.calendar.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;
import com.krhonos.calendar.model.DataPlanning;
import com.krhonos.calendar.model.Planning;
import com.krhonos.calendar.model.Range;
import com.krhonos.calendar.dao.PlanningDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PlanningController {

    @Autowired
    PlanningDao repository;


    @GetMapping("/planning")
    public String getAllPlannings() {
        System.out.println("Get all planning...");

        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Planning.class, new PlanningSerialiser());
        gsonBuilder.registerTypeAdapter(Range.class, new RangeSerialiser());
        gsonBuilder.setPrettyPrinting();
        final Gson gson = gsonBuilder.registerTypeAdapter(Date.class, (JsonSerializer<Date>) (date, type, jsonSerializationContext) -> new JsonPrimitive(date.getTime())).create();

        List<Planning> plannings = new ArrayList<>();
        repository.findAll().forEach(plannings::add);
        List<Planning> planning2 = new ArrayList<>();

        List<DataPlanning> data = new ArrayList<>();

        for (Planning item : plannings){
            Planning javaPuzzlers = new Planning();
            Range range = new Range();
            List<Range> rangeList = new ArrayList<>();
            Range[] rangestab = null;

            if(item.getFrequency() > 1)
            {
                if(item.getDateEnd() == null){
                    item.setDateEnd(LocalDate.of(2020, 12, 31));
                }

                for(LocalDate dateTest = item.getDateStart(); dateTest.isBefore(item.getDateEnd()); dateTest = dateTest.plus(item.getFrequency(), ChronoUnit.WEEKS)){
                    range = new Range();
                    range.setDateStart(dateTest);
                    range.setDateEnd(dateTest.plus(1, ChronoUnit.DAYS));
                    rangeList.add(range);
                }

                rangestab = new Range[rangeList.size()];
                for(int i = 0; i < rangeList.size(); i++){
                    rangestab[i] = rangeList.get(i);
                }

            } else if(item.getFrequency() > 0)
            {
                item.setDateEnd(LocalDate.of(2020, 12, 31));
                range.setDateStart(item.getDateStart());
                range.setDateEnd(item.getDateEnd());
                rangestab = new Range[]{range};
            }

            range.setFrequency(item.getFrequency());

            javaPuzzlers.setId(item.getId());
            javaPuzzlers.setTimeStart(item.getTimeStart());
            javaPuzzlers.setTimeEnd(item.getTimeEnd());
            javaPuzzlers.setDow(new int[] {item.getRecurrent()});
            javaPuzzlers.setRange(rangestab);
            planning2.add(javaPuzzlers);
            DataPlanning dataPlanningItem = new DataPlanning();
            dataPlanningItem.setPlannings(item);
            dataPlanningItem.setRanges(rangeList);
            data.add(dataPlanningItem);
        }

        final String json = gson.toJson(planning2);

        return json;
    }

    @PostMapping(value = "/planning/create")
    public Planning postPlanning(@RequestBody Planning planning) {

        System.out.println(planning);
        Planning _planning = repository.save(new Planning(planning.getTimeStart(), planning.getTimeEnd(), planning.getRecurrent(), planning.getDateStart(), planning.getDateEnd(), planning.getFrequency()));

        return _planning;
    }

    @DeleteMapping("/planning/{id}")
    public ResponseEntity<String> deletePlanning(@PathVariable("id") long id){
        System.out.println("Suppression du planning avec l'id = " + id + "...");

        repository.deleteById(id);

        return new ResponseEntity<>("Le planning a été supprimé", HttpStatus.OK);
    }

    @PutMapping("/planning/{id}")
    public ResponseEntity<Planning> updatePlanning(@PathVariable("id") long id, @RequestBody Planning planning) {
        System.out.println("Planning avec l'id : " + id + " mis à jour...");

        Optional<Planning> planningData = repository.findById(id);

        /*

        if(planningData.isPresent()) {
            Planning _planning = planningData.get();
            _planning.setStart(planning.getStart());
            _planning.setEnd(planning.getEnd());
            return new ResponseEntity<>(dao.save(_planning), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        */
        return null;

    }
}
