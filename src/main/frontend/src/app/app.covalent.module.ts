import { NgModule } from '@angular/core';
import { AppMaterialModule } from './app.material.module'
import { CovalentLayoutModule, CovalentMediaModule } from '@covalent/core'
import { CovalentTextEditorModule } from '@covalent/text-editor';


@NgModule({
    exports: [
        AppMaterialModule,
        CovalentLayoutModule,
        CovalentMediaModule,
        CovalentTextEditorModule
    ]
})
export class AppCovalentModule {}