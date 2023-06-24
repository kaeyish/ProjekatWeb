<template>

<button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "knjiga()" >dodavanje knjige</button>
<p/>
<button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "zanr()" >dodavanje zanra</button>
<p/>
<button class="btn btn-outline-dark" type="submit" v-on:click.prevent = "korisnik()" >dodavanje neaktivnog korisnika</button>
</template>


<script>
export default{
    name:'DodavanjaView',
    methods:{
        knjiga(){
            this.$router.push('/dodavanjeKnjige');
        },
        zanr(){
            this.$router.push('/dodavanjeZanra');
        },
        korisnik(){
            
            this.$router.push('/dodavanjeKorisnika');
        }
    }
}
</script>