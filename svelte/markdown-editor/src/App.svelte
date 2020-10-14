<script>
	import 'codemirror/lib/codemirror.css';
	import 'codemirror/mode/markdown/markdown';
	import { onMount } from 'svelte';
	import CodeMirror from 'codemirror';
	

	let refs = {};
	let code;

	onMount(()=> {
		const editor = CodeMirror.fromTextArea(refs.editor, {
			lineWrapping: true,
			mode: 'markdown',
		});
		editor.setValue('# Hey John')
		return () => {
			editor.toTextArea();
		}
	});
	
</script>

<main>
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

.editor-container :global(.cm-header) {
	font-family: arial; 
}
.editor-container :global(.cm-header-1) { 
	font-size: 150%; 
}
.editor-container :global(.cm-header-2) { 
	font-size: 130%; 
}
.editor-container :global(.cm-header-3) { 
	font-size: 120%; 
}
.editor-container :global(.cm-header-4) { 
	font-size: 110%; }
.editor-container :global(.cm-header-5) { 
	font-size: 100%; 
}
.editor-container :global(.cm-header-6) { 
	font-size: 90%; 
}
.editor-container :global(.cm-strong ) { 
	font-size: 140%; 
}
</style>