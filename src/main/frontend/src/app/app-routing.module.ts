import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DocmdAccordionComponent } from './component/docmd-accordion/docmd-accordion.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/document',
    pathMatch: 'full'
  },
  { path: 'document', component: DocmdAccordionComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
