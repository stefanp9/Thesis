import { IBillItem } from "app/bills/billItem";

export interface IBill {
    id: number,
    date: Date,
    sum: number,
    canceled: boolean,
    items: IBillItem[]
}