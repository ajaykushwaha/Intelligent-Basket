import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import * as $ from "jquery";

@IonicPage()
@Component({
  selector: 'page-map',
  templateUrl: 'map.html',
})
export class MapPage {

  ItemsList: string[];
  ItemsListTemp: string[];
  constructor(public navCtrl: NavController, public navParams: NavParams) {

    this.ItemsList = [
      'Amsterdam',
      'aogota',
      'aata',
      'aata',
      'aaggie',
      'aater'
    ];
  }

  ionViewDidLoad() 
  {

       var og_height_plot = 43;
       var og_width_plot = 189;
       var og_height = 511;
       var og_width = 286;

      $(window).resize(function()
      {
        $(".base_map").width($('body').innerWidth());
        $(".pinner").css('left',((($('body').innerWidth())/og_width)*og_width_plot));
        $(".pinner").css('top',((($('body').innerHeight())/og_height)*og_height_plot));
      });
         


       $(document).ready(function()
      {
        $(".base_map").width($('body').innerWidth());
        $(".pinner").css('left',((($('body').innerWidth())/og_width)*og_width_plot));
        $(".pinner").css('top',((($('body').innerHeight())/og_height)*og_height_plot));          
      });

  }
    
  

  backToCart()
  {
  	this.navCtrl.pop();
  }

  getItemsInMap(ev: any) 
  {
    this.ItemsListTemp = Object.assign([],this.ItemsList);
    const val = ev.target.value;
    if (val && val.trim() != '') 
    {
      this.ItemsListTemp = this.ItemsListTemp.filter((item) => {
        return (item.toLowerCase().startsWith(val.toLowerCase()));
      }).slice(0,3);
    }
    else
    {
      this.ItemsListTemp = []; 
    }  

  }
}

