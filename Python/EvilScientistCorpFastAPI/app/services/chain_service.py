from langchain_classic.chains.llm import LLMChain
from langchain_classic.chains.llm_math.base import LLMMathChain
from langchain_classic.chains.sequential import SimpleSequentialChain
from langchain_core.output_parsers import StrOutputParser
from langchain_core.prompts import ChatPromptTemplate, PromptTemplate
from langchain_core.runnables import RunnableSequence, RunnableLambda
from langchain_ollama import ChatOllama

# This service defines various chains we can use in our app
# I'll do things in a few different ways - up to you which strategies you prefer

# Define our llm for reuse in the methods below
llm = ChatOllama(
    model="llama3.2:3b",
    temperature=0.2
)

# Define our general prompt for reuse in the methods below
prompt = ChatPromptTemplate.from_messages([
    ("system", "You are a helpful non-corporeal assistant at the fictional Evil Scientist Corp."
               "You assist evil scientists with dastardly plans, and are concise yet thorough."
               "You are rather dastardly yourself and it's conveyed subtly in your mostly neutral tone."
               "Your strengths include suggesting items scientists might need for these plans"
               "and you are not afraid to have general chats, nor are you a huge people pleaser."
               "You're determined to help the scientist conduct their evil science, but you don't end with a further suggestion."),
    ("user", "{input}")
])

# Here's our general-purpose chain, used for conversation or other general tasks
def get_chain():

    # this basic chain is just:
        # our prompt (what we're saying to the LLM)
        # and the LLM itself (which generates the response)
    chain = prompt | llm

    return chain

# Here's a more complex chain - it uses two LLM calls sequentially for better responses
def get_simple_sequential_chain():

    output_parser = StrOutputParser()

    # First, we get a response from the general prompt + llm
    # The output parser ensures we just get back a string response
    draft_chain = prompt | llm | output_parser

    # Then, we define a new prompt and create a second chain
    improved_prompt = ChatPromptTemplate.from_messages([
        ("system", "You are a help desk agent at the Evil Scientist Corporation that improves LLM responses. "
                   "Take the initial reply and summarize it into a concise bulleted list of possible solutions. "
                   "Feel free to stay slightly evil in tone but stick to the point. "),
        ("user", "Initial Reply: {input}")
    ])
    improved_chain = improved_prompt | llm

    # Finally, combine both chains into a single sequential chain
    return draft_chain | improved_chain


# # This one is a specialized chain for math calculations
# def get_math_chain():
#     llm = ChatOllama(
#         model="llama3.2:3b",
#         temperature=0.2
#     )
#
#     prompt = ChatPromptTemplate.from_messages([
#         ("system", "You are a specialized assistant that only answers mathematical questions."
#                    "If the question is not mathematical, respond with 'I can only assist with mathematical queries' "
#                    "If the information required to answer is unavailable, respond with 'I don't have that information' and tease the user briefly."),
#         ("user", "{input}")
#     ])
#
#     math_chain = LLMMathChain.from_llm(llm, prompt=prompt)
#     return math_chain