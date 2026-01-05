from langchain_core.prompts import ChatPromptTemplate
from langchain_ollama import ChatOllama

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