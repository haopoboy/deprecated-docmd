import { NgModule, Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatExpansionModule, MatInputModule, MatIconModule, MatButtonModule, MatCardModule, MatDividerModule, MatTooltipModule, MatListModule } from '@angular/material';
import { CovalentTextEditorModule } from '@covalent/text-editor';
import { DocmdAccordionComponent } from './docmd-accordion/docmd-accordion.component';
import { CovalentLayoutModule, CovalentSearchModule } from '@covalent/core';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    DocmdAccordionComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MatExpansionModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatDividerModule,
    MatCardModule,
    MatTooltipModule,
    CovalentTextEditorModule,
    CovalentLayoutModule,
    CovalentSearchModule
  ],
  exports: [
    DocmdAccordionComponent
  ]
})
export class DocmdComponentModule {
}
