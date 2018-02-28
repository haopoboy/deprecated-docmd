import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocmdAccordionComponent } from './docmd-accordion.component';

describe('DocmdAccordionComponent', () => {
  let component: DocmdAccordionComponent;
  let fixture: ComponentFixture<DocmdAccordionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocmdAccordionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocmdAccordionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
