<template>
  <div class="list">
    <div v-for="(file, index) in filtered_list" :key="index" class="list__elem">
      <p>{{ file.name }}</p>
      <a v-bind:href="file.path"><button class="elem__button">⇨</button></a>
    </div>
  </div>
</template>

<script>
export default {
  name: "FilesList",
  props: {
    list: Array,
  },
  computed: {
    filtered_list: function () {
      var keywords = [".mp4", ".mkv", ".wmv", ".mpg", ".jar"];
      return this.list.filter(
        (x) => keywords.indexOf(x.name.substring(x.name.indexOf("."))) > -1
      );
    },
  },
};
</script>

<style scoped>
.list__elem {
  height: auto;
  display: flex;
  flex-direction: row;
  text-align: center;
  vertical-align: center;
  align-items: center;
  justify-content: space-between;
  padding-left: 20px;
  border-bottom: 1px solid black;
}
.list {
  padding: 30px;
  border: 1px solid black;
  border-radius: 10px;
  display: flex;
  flex-direction: column;
  gap: 10px;
}
p {
  margin: 0;
  padding: 0;
}
.elem__button{
  border: 0;
  background: transparent;
  font-size: 2.7em;
}
</style>
