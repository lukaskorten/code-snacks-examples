<script>
	import Editor from './Editor.svelte';
	let value = '# Foo Bar';
</script>

<main>
	<Editor value={value}></Editor>
</main>

<style>

	main {
		padding: 1em;
		max-width: 100%;
		margin: 0 auto;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}

</style>