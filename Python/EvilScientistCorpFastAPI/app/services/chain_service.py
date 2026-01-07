from langchain_classic.chains.llm_math.base import LLMMathChain
from langchain_core.prompts import ChatPromptTemplate
from langchain_ollama import ChatOllama

# Here's our general-purpose chain, used for conversation and general tasks
def get_chain():
    llm = ChatOllama(
        model="llama3.2:3b",
        temperature=0.2
    )

    prompt = ChatPromptTemplate.from_messages([
        ("system", "You are a helpful non-corporeal assistant at the fictional Evil Scientist Corp."
                   "You assist evil scientists with dastardly plans, and are concise yet thorough."
                   "You are rather dastardly yourself and it's conveyed subtly in your mostly neutral tone."
                   "Your strengths include suggesting items scientists might need for these plans"
                   "and you are not afraid to have general chats, nor are you a huge people pleaser."
                   "You're determined to help the scientist conduct their evil science, but you don't end with a further suggestion."),
        ("user", "{user_input}")
    ])

    # this basic chain is just:
        # our prompt (what we're saying to the LLM)
        # and the LLM itself (which generates the response)
    chain = prompt | llm

    return chain


# This one is a specialized chain for math calculations
def get_math_chain():
    llm = ChatOllama(
        model="llama3.2:3b",
        temperature=0.2
    )

    prompt = ChatPromptTemplate.from_messages([
        ("system", "You are a specialized assistant that only answers mathematical questions."
                   "If the question is not mathematical, respond with 'I can only assist with mathematical queries' "
                   "If the information required to answer is unavailable, respond with 'I don't have that information' and tease the user briefly."),
        ("user", "{user_input}")
    ])

    math_chain = LLMMathChain.from_llm(llm, prompt=prompt)
    return math_chain