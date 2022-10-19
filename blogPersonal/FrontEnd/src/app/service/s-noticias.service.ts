import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Noticias } from '../model/noticias';

@Injectable({
  providedIn: 'root'
})
export class SNoticiasService {


 expeURL = 'http://localhost:8080/noticias/';

  constructor(private httpClient: HttpClient) { }


public lista(): Observable<Noticias[]>{
  return this.httpClient.get<Noticias[]>(this.expeURL +'lista');
}

public detail(id: number): Observable<Noticias>{
  return this.httpClient.get<Noticias>(this.expeURL + `detail/${id}`);
}

public save(noticias: Noticias): Observable<any>{
  return this.httpClient.post<any>(this.expeURL + 'crear', noticias);
}

public update(id: number, noticias: Noticias): Observable<any>{
  return this.httpClient.put<any>(this.expeURL + `update/${id}`, noticias);
}

public delete(id: number): Observable<any>{
  return this.httpClient.delete<any>(this.expeURL + `delete/${id}`)
}

}
