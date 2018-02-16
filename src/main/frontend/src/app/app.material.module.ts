import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule, MatToolbarModule, MatSidenavModule, MatCardModule, MatIconModule, MatMenuModule, MatDividerModule, MatExpansionModule } from '@angular/material';

@NgModule({
  exports: [
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
    MatSidenavModule,
    MatCardModule,
    MatMenuModule,
    MatDividerModule,
    MatExpansionModule
  ]
})
export class AppMaterialModule { }
