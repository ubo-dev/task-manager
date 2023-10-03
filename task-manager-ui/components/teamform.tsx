export default function TeamForm({ isToggled }: { isToggled: boolean | undefined }) {
  if (isToggled) {
    return (
      <form className="w-full max-w-lg mt-28">
        <div className="flex flex-wrap -mx-3 mb-6">
          <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label
              className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
              htmlFor="grid-team-name"
            >
              Team Name
            </label>
            <input
              className="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
              id="grid-team-name"
              type="text"
              placeholder="Team Name"
            />
          </div>
        </div>
        <button className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 border border-blue-700 rounded-xl"> Send! </button>
      </form>
    );
  } else return null;
}
