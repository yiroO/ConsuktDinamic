import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CochesComponent } from './components/coches/coches.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'coches', component: CochesComponent,},
  {path:'**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
