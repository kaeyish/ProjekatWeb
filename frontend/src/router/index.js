import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IndexView from '../views/IndexPageView.vue'
import SviKorisnici from '../views/SviKorisnici.vue'
import KorisnikView from '../views/KorisnikView.vue'
import KnjigaView from '../views/KnjigaView.vue'
import SveKnjige from '../views/SveKnjigeView.vue'

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
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
