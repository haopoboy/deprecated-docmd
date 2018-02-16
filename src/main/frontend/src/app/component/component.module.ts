import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatExpansionModule } from '@angular/material';
import { CovalentTextEditorModule } from '@covalent/text-editor';
import { DocmdExpansionComponent } from './docmd-expansion/docmd-expansion.component'

@NgModule({
  declarations: [
    DocmdExpansionComponent
  ],
  imports: [
    MatExpansionModule,
    CovalentTextEditorModule
  ],
  exports: [
    DocmdExpansionComponent
  ]
})
export class DocmdComponentModule { }
