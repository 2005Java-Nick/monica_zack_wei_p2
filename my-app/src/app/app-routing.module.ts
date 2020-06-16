import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login/login.component';
import { BodyComponent } from './body/body.component';
import { RegisterComponent } from './login/register/register.component';
<<<<<<< HEAD
import { AdminComponent } from './body/admin/admin.component';
=======
import { DepartmentComponent } from './body/department/department.component';
import { AdminComponent } from './body/admin/admin.component';
import { CartComponent } from './body/cart/cart.component';
>>>>>>> zack


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'login', component: LoginComponent},
<<<<<<< HEAD
  {path: 'register', component: RegisterComponent},
  { path: 'home', component: BodyComponent },
  { path: 'admin', component: AdminComponent}
=======
  { path: 'register', component: RegisterComponent},
  { path: 'home', component: BodyComponent},
  { path: 'department', component: DepartmentComponent},
  { path: 'admin', component: AdminComponent},
  { path: 'cart', component: CartComponent}
>>>>>>> zack
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
