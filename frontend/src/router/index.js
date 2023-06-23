import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IndexView from '../views/IndexView.vue'
import LogInView from '../views/LogInView.vue'
import LoggedProfile from '../views/LoggedProfile.vue'
import KorisnikView from '../views/KorisnikView.vue'
import KnjigeView from '../views/KnjigeView.vue'
import ZahtevView from '../views/ZahtevView.vue'
import RegisterView from '../views/RegisterView.vue'


const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:'/index',
    name: 'index',
    component: IndexView
  },
  {
    path:'/register',
    name:'register',
    component: RegisterView
  },
  {
    path: '/knjige',
    name: 'knjige',
    component: KnjigeView
  },
  {
    path:'/userProfile',
    name:'userProfile',
    component: LoggedProfile
  },
  {
    path:'/korisnik/:id',
    name:'korisnik',
    component: KorisnikView
  },
  {
    path:'/zahtev/:id/:korisnik_id',
    name: 'zahtev',
    component: ZahtevView
  },
  {
    path: '/login',
    name: 'login',
    component: LogInView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
