export class Product {
    constructor(
        public id: number,
        public productName: string,
        public description: string,
        public price: number,
        public inventoryQuantity: number,
        // TODO: Change before deployment
        public pictureData: string)
    {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
        this.pictureData = pictureData;
    }
}
