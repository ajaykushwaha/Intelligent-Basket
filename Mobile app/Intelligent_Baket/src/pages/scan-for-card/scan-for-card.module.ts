import { NgModule } from '@angular/core';
import { IonicPageModule } from 'ionic-angular';
import { ScanForCardPage } from './scan-for-card';

@NgModule({
  declarations: [
    ScanForCardPage,
  ],
  imports: [
    IonicPageModule.forChild(ScanForCardPage),
  ],
})
export class ScanForCardPageModule {}
