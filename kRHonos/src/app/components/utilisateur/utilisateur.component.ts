import { Component, OnInit } from '@angular/core';
import { UtilisateurService } from "../../services/utilisateur.service";
import { Utilisateur } from "../../models/salaried/utilisateur";
import { Router } from "@angular/router";
import { MatTableDataSource } from "@angular/material";

@Component({
  selector: 'app-root',
  templateUrl: './utilisateur.component.html',
  styleUrls: ['./utilisateur.component.scss']
})
export class UtilisateurComponent implements OnInit {

  displayedColumns = ['id', 'login', 'mot_de_passe'];
  dataSource = new MatTableDataSource();

  constructor(private router: Router, private utilisateurService: UtilisateurService) { }

  ngOnInit(): void {
    this.utilisateurService.getUsers().subscribe(
      data => {
        this.dataSource.data = data;
      }
    );
  }

}
