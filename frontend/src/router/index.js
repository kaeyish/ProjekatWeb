import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IndexView from '../views/IndexPageView.vue'
import SviKorisnici from '../views/SviKorisnici.vue'
import KorisnikView from '../views/KorisnikView.vue'
import KnjigaView from '../views/KnjigaView.vue'
import SveKnjige from '../views/SveKnjigeView.vue'
import LoginView from '../views/LogInView.vue'
import ZanroviView from '../views/ZanrView.vue'
import DodajZanrView from '../views/DodajZanrView.vue'
import PretragaKnjigeView from '../views/PretragaKnjigeView.vue'
import RegisterView from '../views/RegisterView.vue'
import RecenzijeView from '../views/RecenzijeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/index',
    name: 'index',
    component: IndexView
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path:'/register',
    name:'register',
    component: RegisterView
  },
  {
    path:'/korisnici',
    name:'korisnici',
    component: SviKorisnici
  },
  {
    path:'/korisnik/:id',
    name:'korisnik',
    component: KorisnikView
  },
  {
    path: '/knjige',
    name: 'knjige',
    component: SveKnjige
  },
  {
    path:'/knjige/:id',
    name:'knjiga',
    component: KnjigaView
  },
  {
    path: '/zanrovi',
    name: 'zanrovi',
    component: ZanroviView
  },
  {
    path: '/dodajZanr',
    name: 'dodajZanr',
    component: DodajZanrView
  },
  {
    path: '/recenzije',
    name : 'recenzije',
    component : RecenzijeView
  },
  {
    path: '/pretraga',
    name: 'pretraga',
    component: PretragaKnjigeView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
