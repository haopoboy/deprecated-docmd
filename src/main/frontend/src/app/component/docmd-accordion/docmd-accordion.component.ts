import { Component, OnInit } from '@angular/core';
import { MatExpansionModule } from '@angular/material';
import { CovalentTextEditorModule } from '@covalent/text-editor';

@Component({
  selector: 'docmd-accordion',
  templateUrl: './docmd-accordion.component.html',
  styleUrls: ['./docmd-accordion.component.css']
})
export class DocmdAccordionComponent implements OnInit {

  docmds: any[] = [
    {name: 'First docuemnt', ownerName: 'Haopo'},
    {name: 'Second docuemnt', ownerName: 'Haopo'},
  ];

  searchInputTerm = "Hello";

  constructor() { }

  ngOnInit() {
  }

  newDocumentEvent(event) {
    this.docmds.splice(0, 0, {name: 'New'});
  }

  deleteDocumentEvent(event, doc) {
    let index = this.docmds.indexOf(doc);
    this.docmds.splice(index, 1);
  }

  contentChangeEvent(event, row, value) {
    row.content = value;
  }

}
