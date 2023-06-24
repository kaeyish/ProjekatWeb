import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import IndexView from '../views/IndexView.vue'
import LogInView from '../views/LogInView.vue'
import LogOutView from '../views/LogOutView.vue'
import LoggedProfile from '../views/LoggedProfile.vue'
import KorisnikView from '../views/KorisnikView.vue'
import KnjigeView from '../views/KnjigeView.vue'
import KnjigaView from '../views/KnjigaView.vue'
import ZahtevView from '../views/ZahtevView.vue'
import ZahteviView from '../views/ZahteviView.vue'
import RegisterView from '../views/RegisterView.vue'
import SviKorisnici from '../views/SviKorisnici.vue'
import PolicaView from '../views/to-fill/PolicaView.vue'
import AddPolicuView from '../views/AddPolicuView.vue'
import NoviZahtev from '../views/NoviZahtevView.vue'
import DodavanjaView from '../views/Dodavanja.vue'
import DodavanjeZanra from '../views/DodavanjeZanraView.vue'
import DodavanjeKnjige from '../views/DodavanjeKnjigeView.vue'
import ZanroviView from '../views/ZanroviView.vue'
import RecenzijeView from '../views/RecenzijeView.vue'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path:'/dodavanja',
    name:'dodavanja',
    component: DodavanjaView
  },
  {
    path:'/dodavanjeZanra',
    name:'dodavanjeZanra',
    component: DodavanjeZanra
  },

  {
    path:'/dodavanjeKnjige',
    name:'dodavanjeKnjige',
    component: DodavanjeKnjige
  },
  {
    path:'/korisnici',
    name:'korisnici',
    component: SviKorisnici
  },
  {
    path:'/noviZahtev/:id',
    name:'noviZahtev',
    component: NoviZahtev
  },
  {
    path:'/dodaj-policu/:id',
    name:'dodajPolicu',
    component: AddPolicuView
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
    path:'/knjige/:id',
    name:'knjiga',
    component: KnjigaView
  },
  {
    path:'/zahtevi',
    name:'zahtevi',
    component: ZahteviView
  },
  {
    path:'/zahtev/:id/:korisnik_id',
    name: 'zahtev',
    component: ZahtevView
  },
  {
    path:'/polica/:id',
    name: 'polica',
    component: PolicaView
  },
  {
    path: '/login',
    name: 'login',
    component: LogInView
  },
  {
    path: '/logout',
    name: 'logout',
    component: LogOutView
  },
{
  path: '/zanrovi',
  name: 'zanrovi',
  component: ZanroviView
},
{
  path: '/recenzije',
  name: 'recenzije',
  component: RecenzijeView
},
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
