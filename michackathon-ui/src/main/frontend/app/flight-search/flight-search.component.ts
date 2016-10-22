/* tslint:disable:no-unused-variable */
import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {AuthService} from '../shared/auth/auth.service';
/* import {DataTableDirectives} from 'angular2-datatable/datatable'; */

@Component({
  selector: 'michackathon-flight-search',
  templateUrl: './flight-search.component.html',
  styleUrls: ['./flight-search.component.scss']
  /* directives: [DataTableDirectives] */
})
export class FlightSearchComponent implements OnInit {
  data=null;
 
  recommendations: Flights[] = [];
  flights: Flights[] = [];
  editing: boolean = true;
  flightCriteria: FlightCriteria = {
      departure: 'DXB',
      arrival: 'BOM',
      travelDate: new Date(),
    };

  constructor(public http: Http, public authService: AuthService) {
  
  }


  ngOnInit(): any {
    console.log('hello `flight-search` component');
     this.http.get("app/data/data.json")
            .subscribe((data)=> {
                setTimeout(()=> {
                    this.data = data.json();
                }, 1000);
            });
  }


  public resetCriteria() {
  console.log('Reseting');
    this.flightCriteria = {
      departure: '',
      arrival: '',
      travelDate: null,
    };
    this.flights=[];
    this.recommendations=[];
    
  }
  public reset() {
    this.flights=[];
    this.flightCriteria = {
      departure: '',
      arrival: '',
      travelDate: null,
    };
  }



  public search(criteria : FlightCriteria) {
    console.log('in Search');
    this.searchFlights(criteria);
    this.fetchRecommandations()
  }

  private searchFlights(criteria : FlightCriteria) {
    //this.http.post('/api/flights/',criteria, {headers: this.authService.getAuthorizationHeaders()})
    console.log('searchFlights')
      
    //this.http.get("app/data/searchData.json")
    this.http.get("http://localhost:3000/flights/search")
      .subscribe(
        data => {
          this.flights = data.json();
        },
        err => console.log('Something went wrong')
      );
  }
  
   private fetchRecommandations() {
    
   // this.http.get('/api/recommendations/', {headers: this.authService.getAuthorizationHeaders()})
    //this.http.get("app/data/recommendations.json")
    this.http.get("http://localhost:3000/flights/recommendations")
      .subscribe(
        data => {
          this.recommendations = data.json();
        },
        err => console.log('Something went wrong')
      );
  }

}

export interface Flights {
  departure: string;
  arrival: string;
  departureDate: Date;
  arrivalDate: Date;
  price: number;
}

export interface FlightCriteria {
  departure: string;
  arrival: string;
  travelDate: Date;
}
