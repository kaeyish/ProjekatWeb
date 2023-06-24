<template>
    <div>
    <h1>Trazena knjiga</h1>
    
          <ul v-if="knjigePoNaslovu.length > 0">
            <li v-for="knjiga in knjigePoNaslovu" :key="knjiga.naslov">
              
               <p>Naziv: {{ knjiga.naslov }}</p>
            </li>
          </ul>
          <p v-else>No books found.</p>
    </div>
    </template>
    
    
    <script>
    import axios from 'axios';
    
    export default {
      data() {
        return {
          knjigePoNaslovu:[],
        };
      },
      created() { 
          const searchTerm=this.$route.query.searchTerm;
    
    
          if(searchTerm)
          {
            axios.get(`http://localhost:9090/api/knjige/${searchTerm}`)
            .then(response=>{
              this.knjigePoNaslovu=[response.data];
            })
          
          .catch(error=>{
            console.error('Error fetching books by title',error);
          });
        }
      }
    
    };
    </script>
    
    
    <style>
    </style>
    
    
    
    
    
    