<script>
  import 'codemirror/lib/codemirror.css';
	import 'codemirror/mode/markdown/markdown';
  import CodeMirror from 'codemirror';
  import { onMount } from 'svelte';

	export let value = '';
  let textArea;

  onMount(() => {
    const editor = CodeMirror.fromTextArea(textArea, {
			lineWrapping: true,
			mode: 'markdown',
		});
		editor.focus();
		return () => {
			editor.toTextArea();
		}
  });
</script>

<div class="editor-container">
  <textarea bind:this={textArea} {value} readonly></textarea>
</div>

<style>
	.editor-container {
		margin: 2rem auto 0;
		width: 800px;
		padding: 2rem;
		background: white;
		border-radius: 0.5rem;
		box-shadow: 0 2px 4px rgba(0,0,0,0.1);
	}

	.editor-container :global(.CodeMirror-cursor) {
		border-left: 2px solid rgb(26, 154, 240);
	}

	.editor-container :global(.cm-header) {
		color: black;
	}
	.editor-container :global(.cm-header-1) { 
		font-size: 200%; 
	}
	.editor-container :global(.cm-header-2) { 
		font-size: 150%; 
	}
	.editor-container :global(.cm-header-3) { 
		font-size: 120%; 
	}
</style>