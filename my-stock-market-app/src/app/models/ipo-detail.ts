import { Time } from '@angular/common';
import { Timestamp } from 'rxjs';

export class IpoDetail {
    ipoId: number;
    exchange: string;
    sharePrice : number;
    numberOfShares : number;
    timestamp :  Time;
}
