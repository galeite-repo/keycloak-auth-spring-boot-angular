import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ListaComponent } from './foo/lista/lista.component';
import { DetailComponent } from './foo/detail/detail.component';
import { UpdateComponent } from './foo/update/update.component';
import { CreateComponent } from './foo/create/create.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'lista', component: ListaComponent},
  {path: 'detail/:id', component: DetailComponent},
  {path: 'update/:id', component: UpdateComponent},
  {path: 'create', component: CreateComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
