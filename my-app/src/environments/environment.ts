// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  
  loginURL: 'http://localhost:8080/Project2/login',
  signupURL: 'http://localhost:8080/Project2/signup',
  productsURL: 'http://localhost:8080/Project2/products',
  productsDeleteURL: 'http://localhost:8080/Project2/products/delete',
  invoicesURL: 'http://localhost:8080/Project2/invoices',
  driverURL: 'http://localhost:8080/Project2/driver',
  driverShiftStatusURL: 'http://localhost:8080/Project2/driver/ShiftStatus',
  driverShiftToggleURL: 'http://localhost:8080/Project2/driver/ShiftToggle',

  
  /*
  loginURL: 'http://weiwu.online:8080/OGSS/OGSS/login',
  signupURL: 'http://weiwu.online:8080/OGSS/signup',
  productsURL: 'http://weiwu.online:8080/OGSS/OGSS/products',
  productsDeleteURL: 'http://weiwu.online:8080/OGSS/products/delete',
  invoicesURL: 'http://weiwu.online:8080/OGSS/invoices',
  driverURL: 'http://weiwu.online:8080/OGSS/driver',
  driverShiftStatusURL: 'http://weiwu.online:8080/OGSS/ShiftStatus',
  driverShiftToggleURL: 'http://weiwu.online:8080/OGSS/ShiftToggle',
  */
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
