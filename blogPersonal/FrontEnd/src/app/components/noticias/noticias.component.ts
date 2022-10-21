import { Component, OnInit } from '@angular/core';
import { SNoticiasService } from 'src/app/service/s-noticias.service';
import { Noticias } from 'src/app/model/noticias';


@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.css']
})
export class NoticiasComponent implements OnInit {

  noticias: Noticias[] = [];

  constructor(private sNoticias: SNoticiasService) { }

  ngOnInit(): void {
    this.cargarExperiencia();
  }

  cargarExperiencia(): void {
    this.sNoticias.lista().subscribe(data => { this.noticias = data; })
  }
  }


