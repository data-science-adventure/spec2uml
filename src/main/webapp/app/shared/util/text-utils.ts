/**
 * Truncates text to a maximum number of words and appends an ellipsis if truncated.
 *
 * @param text The input string to truncate.
 * @param maxWords The maximum number of words allowed (default is 20).
 * @returns The truncated string, or the original text if under the limit.
 */
export const truncateWords = (text: string | null | undefined, maxWords = 20): string => {
  if (!text) return '';
  const words = text.trim().split(/\s+/);
  if (words.length <= maxWords) return text;
  return words.slice(0, maxWords).join(' ') + '...';
};
