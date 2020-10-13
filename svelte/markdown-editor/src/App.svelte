<script>
	import 'codemirror/lib/codemirror.css';
	import { onMount } from 'svelte';
	import CodeMirror from 'codemirror';

	let refs = {};
	let code = '## Dies ist ein Test';

	onMount(()=> {
		const editor = CodeMirror.fromTextArea(refs.editor, {
			mode: 'Gfm'
		});
		editor.setValue(code || '');
		editor.refresh();
		return () => {
			editor.toTextArea();
		}
	});
	
</script>

<main>
	<h1>Markdown Editor</h1>
	<div class="editor-container">
		<textarea bind:this={refs.editor} value={code} readonly></textarea>
	</div>
</main>

<style>
	main {
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		font-size: 4em;
		font-weight: 100;
	}

	.editor-container {
		margin-top: 2rem;
		height: 20rem;
		width: 30rem;
		position: relative;
		border-radius: 0.5rem;
		border: 2px solid #ff3e00;
		padding: 1rem;
	}

	textarea {
		visibility: hidden;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>