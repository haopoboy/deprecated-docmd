import { NgModule } from '@angular/core';
import { AppMaterialModule } from './app.material.module'
import { CovalentLayoutModule, CovalentMediaModule } from '@covalent/core'


@NgModule({
    exports: [
        AppMaterialModule,
        CovalentLayoutModule,
        CovalentMediaModule
    ]
})
export class AppCovalentModule {}