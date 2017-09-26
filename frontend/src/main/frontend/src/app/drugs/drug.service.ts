import { Injectable } from '@angular/core';
import { IDrugs } from "./drugs";
import { HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Http, RequestOptions, Response, Headers} from "@angular/http";
import { Observable } from "rxjs/Observable";
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/map';
import { Drug } from 'app/drugs/drug-edit';


@Injectable()
export class DrugService {
/*     extractData(arg0: any): any {
        throw new Error("Method not implemented.");
    } */
    private _drugsUrl = 'http://localhost:8080/drugs'
    private formsUrl ='http://localhost:8080/drugs/forms'
    private innsUrl = 'http://localhost:8080/drugs/inns'

    constructor(private _http: HttpClient, private http : Http ){
    }

    getDrugs(): Observable<IDrugs[]> {
        return this._http.get<IDrugs[]>(this._drugsUrl)
        .do(data => console.log('All: ' + JSON.stringify(data)))
        .catch(this.handleError);
    }

    getOneDrug(id:number):Observable<Drug> {
        if (id === 0) {
        return Observable.create((observer: any) => {
            observer.next(this.initializeProduct());
            observer.complete();
        }); 
        }
        const url = `${this._drugsUrl}/${id}`
        return this.http.get(url)
                .map(this.extractData)
                .do(data => console.log('All: ' + JSON.stringify(data)))
                .catch(this.handleError);
    }

    getDrug(id: number): Observable<IDrugs> {
        return this.getDrugs()
            .map((drugs: IDrugs[]) => drugs.find(d => d.id === id));
    }

    getForms(): Observable<any> {
        return this.http.get(this.formsUrl)
            .map(this.extractForms)
            .do(data => console.log('All: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    getInns(): Observable<any> {
        return this.http.get(this.innsUrl)
            .map(this.extractForms)
            .do(data => console.log('All: ' + JSON.stringify(data)))
            .catch(this.handleError);
    }

    postDrug(drug: Drug):Observable<any>{
       // console.log(JSON.stringify(drug));
        let body = JSON.stringify(drug);
        let headers = new Headers ({'Content-Type' : 'application/json'}) ;
        let options = new RequestOptions ({headers : headers})

        return this.http.post(this._drugsUrl,body,options)
            // .map(this.extractData)
            .do(data => console.log("data:"+JSON.stringify(data)))
            .catch(this.handleError);      
    }
    putDrug(drug: Drug, id:number): Observable<any>{
        const url = `${this._drugsUrl}/${id}`;
        let body = JSON.stringify(drug);
        let headers = new Headers ({'Content-Type' : 'application/json'}) ;
        let options = new RequestOptions ({headers : headers})
        return this.http.put(url,body, options)
            //.map(this.extractData)
            .do(data => console.log("data:"+JSON.stringify(data)))
            .catch(this.handleError);  
    }

    deleteDrug(drug: Drug, id:number): Observable<any>{
        let body = JSON.stringify(drug);
        const url = `${this._drugsUrl}/${id}`;
        return this.http.delete(url)
        //.map(this.extractData)
        .do(data => console.log("data:"+JSON.stringify(data)))
        .catch(this.handleError);  

    }

    // private handleError(err: any) {
    //     // in a real world app, we may send the server to some remote logging infrastructure
    //     // instead of just logging it to the console
    //     let errorMessage = '';
    //     if (err.error instanceof Error) {
    //         // A client-side or network error occurred. Handle it accordingly.
    //         errorMessage = `An error occurred: ${err.error.message}`;
    //     } else {
    //         // The backend returned an unsuccessful response code.
    //         // The response body may contain clues as to what went wrong,
    //         errorMessage = `Server returned code: ${err.status}, error message is: ${err.message}`;
    //     }
    //     console.error(errorMessage);
    //     return Observable.throw(errorMessage);
    // }

    private handleError(error : any){
        console.error("post error", error);
         return Observable.throw(error);
    }

    private extractData(response: Response) {
        let body = response.json();
        console.log (body);
        return body || {};
    }

    private extractForms(response: Response) {
        let body = response.json();
        console.log(body);
        return body || {};
    }



    initializeProduct(): Drug {
        // Return an initialized object
        return {
            id: 0,
            name : null,
            dosage : null,
            price : null,
            drugForm : 'default',
            drugInn : 'default',
            drugManufacturer : 'default'
        };
    }

}
