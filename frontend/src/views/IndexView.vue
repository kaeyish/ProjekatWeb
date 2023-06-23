<template>
    <div class="home">
      <IndexPage msg="Welcome to our Web App !!"/>
    </div>
  </template>
  
  <script>
  // @ is an alias to /src
  import IndexPage from '@/components/IndexPage.vue'
  
  export default {
    name: 'IndexView',
    components: {
      IndexPage
    }
  }
  </script>
  