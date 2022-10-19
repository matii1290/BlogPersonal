import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NuevaNoticiaComponent } from './components/noticias/nueva-noticia/nueva-noticia.component';

const routes: Routes = [
  { path: 'crear', component: NuevaNoticiaComponent},
  { path: '', component: HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
