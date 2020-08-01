import { Component, OnInit } from '@angular/core';
import { CochesService } from "../../service/coches.service"
import { coches } from 'src/app/model/coches.model';

@Component({
  selector: 'app-coches',
  templateUrl: './coches.component.html',
  styleUrls: ['./coches.component.css']
})
export class CochesComponent implements OnInit {

  coches: coches[] = [];
  marcas: any[] = [];
  marcaElegida: any = null;
  busqueda: coches = {
    marca: '',
    modelo: '',
    version: '',
    cambios: '',
    color: '',
    kmDesde: null,
    kmHasta: null
  };

  constructor(private carService: CochesService) { }

  ngOnInit(): void {
    this.getMarcas();
   this.getCoches();
  }

  getMarcas():void {
    this.carService.getMarcas().subscribe(
      resp => {
        this.marcas = resp
        console.log('data', resp);
      }, error => {
        console.error(error);
      }
    );
  }

  getCoches(): void {
    this.carService.getCoches(this.busqueda).subscribe(
      resp => {
        this.coches = resp;
      }, err => {
        console.error(err);
      }
    );
  }

  onChange(){
    if(this.marcaElegida){
      this.busqueda.marca = this.marcaElegida.name;
      console.log('marca', this.marcaElegida.name);
    } else {
      this.busqueda.marca = '';
      this.busqueda.modelo = '';
    }
    this.getCoches();
  }

  limpiarVersion(): void {
    this.busqueda.version = '';
    this.getCoches();
  }

  limpiarkmDesde(): void {
    this.busqueda.kmDesde = null;
    this.getCoches();
  }

  limpiarkmHasta(): void {
    this.busqueda.kmHasta = null;
    this.getCoches();
  }

  resetAll(): void {
    this.marcaElegida = null;
    this.busqueda.marca = '';
    this.busqueda.modelo = '';
    this.busqueda.version = '';
    this.busqueda.cambios = '';
    this.busqueda.color = '';
    this.busqueda.kmDesde = null;
    this.busqueda.kmHasta = null;
    this.getCoches();
  }
}
