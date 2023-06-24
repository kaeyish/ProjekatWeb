<template>
  <!-- <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div> -->
  <h1>WELCOME</h1>
  <h4>Pretraga knjiga po naslovu</h4>
      <input type="text" v-model="searchTerm" placeholder="Naziv knjige">
      <button @click="search">Search</button>
</template>

<script>
// @ is an alias to /src
//import HelloWorld from '@/components/HelloWorld.vue'

//import axios from 'axios';

export default {
  name: 'HomePage',
  data() {
    return {
      searchTerm:'',
    };
  },
  methods: {
    search(){
      if(this.searchTerm){
        this.$router.push({path:'/pretraga',query:{searchTerm:this.searchTerm}});
      }
    },
},
};
</script>
