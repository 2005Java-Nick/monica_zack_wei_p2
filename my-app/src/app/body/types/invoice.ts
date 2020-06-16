import { UserAccount } from 'src/app/login/types/UserAccount';
import { ItemList } from './itemlist';

export class Invoice {
    id: number;
    shippingDate: string;
    purchaseDate: string;
    subTotal: number;
    tax: number;
    discountCode: string;
    deliveryCharge: number;
    finalPrice: number;
    status: string;
    customerComments: string;
    deliveryComments: string;
    paymentMethod: string;
    cardNumber: string;
    driver: UserAccount;
    customer: UserAccount;
    itemList: ItemList[];
}
