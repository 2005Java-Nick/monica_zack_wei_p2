import { AccountType } from './AccountType';

export class UserAccount {
id: number;
username: string;
password: string;
sessionToken: string;
phoneNumber: string;
email: string;
address: string;
state: string;
city: string;
zip: string;
firstname: string;
lastname: string;
accountType: AccountType;
}
