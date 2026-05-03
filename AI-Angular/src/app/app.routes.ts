import { Routes } from '@angular/router';
import { MainLayout } from './core/layout/main-layout/main-layout';
import { Home } from './routes/home/home';
import { Login } from './routes/auth/login/login';
import { Register } from './routes/auth/register/register';

export const routes: Routes = [
    {
        path: '',
        component: MainLayout,
        children: [
            { 
                path: '', component: Home 
            },
            {
                path: 'login', component: Login
            },
            {
                path: 'register', component: Register
            },
        ],
    },
    {
        path: '**',
        redirectTo: '',
    },
];