import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';
import { coches } from '../model/coches.model';

  const httoOptions ={
    headers: new HttpHeaders({ 
    'Access-Control-Allow-Origin':'*',
     })
  }

@Injectable({
  providedIn: 'root'
})
export class CochesService {
  
  endPoint: 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  // Obtener la lista completa
  getMarcas(): Observable<any[]>{
    return this.http.get<any[]>('http://localhost:8080/marca/list', httoOptions);
  }

  // Obtener la busqueda
  getCoches(busqueda: coches): Observable<any[]>{
    return this.http.post<any[]>('http://localhost:8080/coche/list', busqueda ,httoOptions);
  }

}
