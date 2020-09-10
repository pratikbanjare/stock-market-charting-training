import { IpoDetail } from './ipo-detail';

export class Company {
    companyId : number;
    companyName: string;
    turnover: number;
    ceo: string;
    writeup: string;
    companyCode: string;
    exchanges: string[];
    directors: string[];
    ipoDetails: IpoDetail[];

}
