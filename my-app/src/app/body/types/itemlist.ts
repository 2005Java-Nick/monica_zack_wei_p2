import { UserAccount } from 'src/app/login/types/UserAccount';
import { Invoice } from './Invoice';
import { Product } from './product';

export class ItemList {

    order: Invoice; // invoice can be empty
    product: Product;
    quantity: number;

    constructor(item: Product, amount: number) {
        this.product = item;
        this.quantity = amount;
    }
}
