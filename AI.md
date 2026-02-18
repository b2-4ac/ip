I used ChatGPT to help with the refactoring of AddCommand and TaskListTest in commit 2dea779.

While the LLM was effective in refactoring and making it neater, I needed to re-adjust some of
the styling choices it had made, like adding an extra indent in `switch-case` statements.

It had suggested the use of private helper methods to format my new output, which I then took
the idea of and placed both methods into a new Response class so that I could use them across
all my Command classes easier.

After making those changes, since the output of my commands were changed as well as the outputs
of my TaskList methods were changed, my test cases for TaskList also needed to be changed. I 
used ChatGPT to help re-adjust my existing test cases so that they would work as intended.
