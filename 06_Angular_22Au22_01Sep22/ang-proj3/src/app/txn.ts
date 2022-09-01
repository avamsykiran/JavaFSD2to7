import { AccountHolder } from "./account-holder";

export interface Txn {
    txnId:number;
	header:string;
	amount:number;
	type:string;
	dateOfTransaction:Date;
	holder?:AccountHolder;
}
