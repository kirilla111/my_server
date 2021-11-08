<template>
  <div id="app">
    <h2 class="app__title">Список всех видео файлов:</h2>
    <FilesList :list="getList()" />
  </div>
</template>

<script>
import FilesList from "./components/FilesList.vue";
import axios from "axios";

export default {
  name: "App",
  data() {
    return {
      response: [
        {
          fail: false,
          filesInfo: [
            { name: "classes", path: "target\\classes", type: "Directory" },
            {
              name: "generated-sources",
              path: "target\\generated-sources",
              type: "Directory",
            },
            {
              name: "generated-test-sources",
              path: "target\\generated-test-sources",
              type: "Directory",
            },
            {
              name: "a.mp4",
              path: "Downloads/",
              type: "Directory",
            },
            {
              name: "b.mp4",
              path: "target\\generated-test-sources",
              type: "Directory",
            },
            {
              name: "maven-archiver",
              path: "target\\maven-archiver",
              type: "Directory",
            },
            {
              name: "maven-status",
              path: "target\\maven-status",
              type: "Directory",
            },
            {
              name: "rest-service-0.0.1-SNAPSHOT.jar.original",
              path: "target\\rest-service-0.0.1-SNAPSHOT.jar.original",
              type: "File",
            },
            {
              name: "surefire-reports",
              path: "target\\surefire-reports",
              type: "Directory",
            },
            {
              name: "test-classes",
              path: "target\\test-classes",
              type: "Directory",
            },
          ],
        },
      ],
    };
  },
  components: {
    FilesList,
  },
  methods: {
    getList() {
      //console.log(this.response.filesInfo);
      return this.response.filesInfo;
    },
    getListInfo() {
      let vm = this;
      axios
        .get("http://192.168.0.118:8091/files")
        //.get("http://localhost:8091/files")
        //.get("https://api.openweathermap.org/data/2.5/onecall?lat=11&lon=11&exclude=minutely&appid=4398fb47bec1e4f059c85184f9291200")
        .then(function (response) {
          vm.response = response.data;
          //console.log(response.data.filesInfo);
        });
    },
  },
  beforeMount() {
    this.getListInfo();
  },
};
</script>

<style>
body {
  padding: 0;
  margin: 0;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 30px;
}
.app__title {
  padding-bottom: 10px;
}
</style>
