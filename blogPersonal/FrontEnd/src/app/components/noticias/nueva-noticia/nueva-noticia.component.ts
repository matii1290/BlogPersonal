import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Noticias } from 'src/app/model/noticias';
import { SNoticiasService } from 'src/app/service/s-noticias.service';

@Component({
  selector: 'app-nueva-noticia',
  templateUrl: './nueva-noticia.component.html',
  styleUrls: ['./nueva-noticia.component.css']
})
export class NuevaNoticiaComponent implements OnInit {
  nombreN: string = '';
  descripcionN: string = '';


  constructor(private sNoticias: SNoticiasService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const noticias = new Noticias(this.nombreN, this.descripcionN);
    this.sNoticias.save(noticias).subscribe(data=>{
      alert("Noticia Creada");
      this.router.navigate(['']);
    }, err =>{
      alert("Fallo la creación");
      this.router.navigate(['']);
    }
    )
  }
    
  }

